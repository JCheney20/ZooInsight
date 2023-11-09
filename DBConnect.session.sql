--@block
UPDATE users
Set username='JCheney', pass_word='Admin'
WHERE AccNum=11;

--@block
SELECT * FROM users WHERE username='JCheney' AND pass_word='Admin';

