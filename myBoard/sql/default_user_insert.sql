--5.6버전 
update mysql.user set password=password('choon27') where user='root';
FLUSH PRIVILEGES;

insert into mysql.user (Host, User, Password, ssl_cipher, x509_issuer, x509_subject, authentication_string)
values('localhost','root', password('choon27'),'','','','');

--ip허용
INSERT INTO mysql.user (host,user,password) VALUES ('111.222.33.44','root',password('choon27')); 
GRANT ALL PRIVILEGES ON *.* TO 'root'@'111.222.33.44'; 
FLUSH PRIVILEGES;