
-- Drop user first if they exist
DROP USER if exists 'lucawebapp'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'lucawebapp'@'localhost' IDENTIFIED BY 'lucawebapp';

GRANT ALL PRIVILEGES ON * . * TO 'lucawebapp'@'localhost';