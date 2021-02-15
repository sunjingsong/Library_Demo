## A Simple Library
This demo is a simple library which provides Rest API for CRUD of h2 database(one to many relationships of Library and book).

## APIs
# Libraries
GET All Libraries
http://localhost:8080/api/libraries

GET/PUT/DELETE One library
http://localhost:8080/api/libraries/{id}

# Books
GET All Books
http://localhost:8080/api/books

GET/PUT/DELETE One Book
http://localhost:8080/api/books/{id}




## Test Cases
# POST First Library
API:
http://localhost:8080/api/libraries

Body:
{
    "name":"OC Library",
    "address": "14361 Yale, Irvine, CA 92604",
    "books": []
}

# POST A BOOK TO The First Library
API:
http://localhost:8080/api/books
Body:
{
    "name": "When Breath Becomes Air",
    "author": "Paul Kalanithi",
    "library": {
        "id":1
	}
}

# POST Second Library
API:
http://localhost:8080/api/libraries

Body:
{
    "name":"Los Angeles Central Library",
    "address": "630 W 5th St, Los Angeles, CA 90071",
    "books": []
}

# POST A BOOK TO The Second Library
API:
http://localhost:8080/api/books
Body:
{
    "name": "Sapiens: A Brief History of Humankind",
    "author": "Yuval Noah Harari",
    "library": {
        "id":2
	}
}

# POST Third Library
API:
http://localhost:8080/api/libraries

Body:
{
    "name":"Fake Library",
    "address": "Utopia",
    "books": []
}

# POST A BOOK TO The Third Library
API:
http://localhost:8080/api/books
Body:
{
    "name": "Virtual Book",
    "author": "Virtual Author",
    "library": {
        "id":3
	}
}

# GET ALL libraries
API:
http://localhost:8080/api/libraries

# GET One Library
API:
http://localhost:8080/api/libraries/1

# GET ALL Books
API:
http://localhost:8080/api/books

# GET One Book
API:
http://localhost:8080/api/books/3


# PUT A library
API:
http://localhost:8080/api/libraries/3

Body:
{
    "name":"Real Library",
    "address": "Some Place"
}

# PUT One Book
API:
http://localhost:8080/api/books/3
{
    "name": "Real Book",
    "author": "Real Author",
    "library": {
        "id":3
	}
}



# DELETE One Book
API:
http://localhost:8080/api/books/3

# DELETE One Library
API:
http://localhost:8080/api/libraries/3






