# book-user-store
There are 3 entities in the Book store project : User,Role,BookEntity;
BookEntity fields: name , author , details;
User: username , email , password , list of roles , list of books;
Role: name;
We have 3 role : user , publisher , admin;
As a user, we can to register and login to the system 
As a user,, we get an error message if the username and password are wrong 
As a user, we can search specific book
As a user, we can get list of books
As a user, we can get list all books published by specific publisher
As a publisher, we can do as above
Additionally:
As a publisher, we can add new book to the book list
As a publisher, we can update a specific book details 
As a publisher, we can delete a specific book or all books 
As a admin,we can do all of the above

I use dao and dto design patterns
Also I have Security configuration , Authentication with jwt.

Note:I recommend checking the project with a postman. There may be a problem with the swagger.

