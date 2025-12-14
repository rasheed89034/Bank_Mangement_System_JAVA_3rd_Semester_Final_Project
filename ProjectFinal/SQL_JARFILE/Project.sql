-- Personal Details------------------------
create table signup(
    formno varchar(20) PRIMARY KEY,  -- <--- PRIMARY KEY IS HERE
    name varchar(20), 
    father_name varchar(20), 
    dob varchar(20), 
    gender varchar(20), 
    email varchar(30), 
    marital_status varchar(20), 
    address varchar(40), 
    city varchar(25), 
    pincode varchar(20), 
    state varchar(25)
);

-- Eucational Records and Income------------------------

-- 2. CHILD TABLE (Links to Parent via Foreign Key)
create table signuptwo(
    formno varchar(20), 
    religion varchar(20), 
    category varchar(20), 
    income varchar(20), 
    education varchar(20), 
    occupation varchar(20), 
    pan varchar(20), 
    aadhar varchar(20), 
    seniorcitizen varchar(20), 
    existingaccount varchar(20),
    FOREIGN KEY (formno) REFERENCES signup(formno) -- <--- FOREIGN KEY LINKS TO SIGNUP
);


-- Account type---------------------------------
-- 3. CHILD TABLE 
create table signupthree(
    formno varchar(20), 
    accountType varchar(40), 
    card_number varchar(25) UNIQUE, -- Card number should also be unique
    pin varchar(10), 
    facility varchar(100),
    FOREIGN KEY (formno) REFERENCES signup(formno)
);


-- Pin and card Number---------------------------------------
-- 4. LOGIN TABLE (Links authentication to the form)
create table login(
    formno varchar(20), 
    card_number varchar(25), 
    pin varchar(10),
    FOREIGN KEY (formno) REFERENCES signup(formno)
);


-- Deposite and withdrawal------------------------------------------------
-- 5. BANK TRANSACTION TABLE
-- In this project structure, I usually link by PIN or Card Number
create table bank(
    pin varchar(10), 
    date varchar(50), 
    type varchar(20), 
    amount varchar(20)
    -- I don't usually put a Foreign Key here in this specific project 
    -- because I might change your PIN, which complicates things in simple Java projects.
);

-- delete from signup;
-- delete from signuptwo;
-- delete from signupthree;
-- delete from login;
-- delete from bank;




-- UPDATE login SET pin = TRIM(pin);
-- UPDATE bank SET pin = TRIM(pin);
-- UPDATE signupthree SET pin = TRIM(pin);

-- select date, type, amount from bank where pin = '9080' order by date desc limit 5;

-- select s.name,s.father_name,l.card_number, st.accountType,l.pin
-- from signup s join login l on s.formno = l.formno
-- join signupthree st on s.formno = st.formno;

-- delete  from signupthree where formno = 3330;

-- delete  from signuptwo where formno = 3330;

-- delete  from login where formno = 3330;

-- delete  from bank where pin = 1132;


-- delete  from signup where formno = 3330;


-- Creating a function for total balance for balance inquary ------------------------------
DELIMITER $$ -- $$ use for to continue the function or a trigger after a semicolon also until the ends of $$.

CREATE FUNCTION calculate_balance(input_pin VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total_balance INT DEFAULT 0;

    -- Logic: 
    -- 1. Filter by PIN
    -- 2. Remove spaces from 'amount' column (REPLACE)
    -- 3. Convert to Number (CAST)
    -- 4. If Deposit, add (+); if anything else, subtract (-)
    
    SELECT 
    --    COALESCE means If the user has no transactions, SUM returns NULL. This forces it to return 0 
    -- instead so your program doesn't crash.
        COALESCE(SUM(
            CASE 
               WHEN UPPER(TRIM(type)) = 'DEPOSIT' 
                THEN CAST(REPLACE(amount, ' ', '') AS SIGNED)
                ELSE -CAST(REPLACE(amount, ' ', '') AS SIGNED)
            END
        ), 0) 
    INTO total_balance
    FROM bank
    WHERE pin LIKE input_pin;

    RETURN total_balance;
END$$

DELIMITER ;

-- calling the above fuction------------------------
SELECT calculate_balance('6745');



-- --------------------Creating a trigger changing in one place will automatically change in all places related data-----------------------------------------
DELIMITER $$

-- Delete the trigger if it already exists to avoid errors
DROP TRIGGER IF EXISTS sync_pin_update $$

CREATE TRIGGER sync_pin_update
AFTER UPDATE ON login
FOR EACH ROW
BEGIN
    -- Check if the PIN is actually being changed "<>" not equal 
    IF NEW.pin <> OLD.pin THEN
        -- Automatically update the 'bank' table
        UPDATE bank 
        SET pin = NEW.pin 
        WHERE pin = OLD.pin;

        -- Automatically update the 'signupthree' table
        UPDATE signupthree 
        SET pin = NEW.pin 
        WHERE pin = OLD.pin;
    END IF;
END$$

DELIMITER ;


-- creating a procedure for creating mini statement`-------------------------
DELIMITER $$

-- Drop the procedure if it exists to avoid errors when re-running
DROP PROCEDURE IF EXISTS get_mini_statement $$

CREATE PROCEDURE get_mini_statement(IN input_pin VARCHAR(50))
BEGIN
    -- Select the necessary columns
    SELECT date, type, amount 
    FROM bank 
    -- Use LIKE to handle cases where PIN might have spaces (e.g., ' 1234 ')
    WHERE pin LIKE input_pin
    -- Order by Date Descending (Newest first) so it looks like a real bank statement
    ORDER BY date DESC
    -- Limit to the last 10 transactions to fit in the window
    LIMIT 10;
END$$

DELIMITER ;


