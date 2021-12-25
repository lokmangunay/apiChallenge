In this project a Restful based web service is tested by using Java - Rest Assured Library. 

Firstly the tester search for a movie and see all the movies related to it. For example:

Search for: Spider ---> https://www.omdbapi.com/?apikey=[yourApiKey]&s=spider

    Response: 
        
                            {
                  "Search":[
                      {
                          "Title":"Spider-Man",
                          "Year":"2002",
                          "imdbID":"tt0145487",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BZDEyN2NhMjgtMjdhNi00MmNlLWE5YTgtZGE4MzNjMTRlMGEwXkEyXkFqcGdeQXVyNDUyOTg3Njg@._V1_SX300.jpg"
                      },
                      {
                          "Title":"The Amazing Spider-Man",
                          "Year":"2012",
                          "imdbID":"tt0948470",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BMjMyOTM4MDMxNV5BMl5BanBnXkFtZTcwNjIyNzExOA@@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man 2",
                          "Year":"2004",
                          "imdbID":"tt0316654",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BMzY2ODk4NmUtOTVmNi00ZTdkLTlmOWYtMmE2OWVhNTU2OTVkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man: Homecoming",
                          "Year":"2017",
                          "imdbID":"tt2250912",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man: Homecoming",
                          "Year":"2017",
                          "imdbID":"tt2250912",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man: Homecoming",
                          "Year":"2017",
                          "imdbID":"tt2250912",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man 3",
                          "Year":"2007",
                          "imdbID":"tt0413300",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg"
                      },
                      {
                          "Title":"The Amazing Spider-Man 2",
                          "Year":"2014",
                          "imdbID":"tt1872181",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BOTA5NDYxNTg0OV5BMl5BanBnXkFtZTgwODE5NzU1MTE@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man: Into the Spider-Verse",
                          "Year":"2018",
                          "imdbID":"tt4633694",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BMjMwNDkxMTgzOF5BMl5BanBnXkFtZTgwNTkwNTQ3NjM@._V1_SX300.jpg"
                      },
                      {
                          "Title":"Spider-Man: Far from Home",
                          "Year":"2019",
                          "imdbID":"tt6320628",
                          "Type":"movie",
                          "Poster":"https://m.media-amazon.com/images/M/MV5BMGZlNTY1ZWUtYTMzNC00ZjUyLWE0MjQtMTMxN2E3ODYxMWVmXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_SX300.jpg"
                      }
                  ],
                  "totalResults":"608",
                  "Response":"True"
              }

--------------

Now send another request by using ImdbID for "Spider-Man: Far from Home"
    --->  "imdbID":"tt6320628"
    ---> https://www.omdbapi.com/?i=tt6320628&apikey=[yourApiKey]
    
    
              {
              "Title":"Spider-Man: Far from Home",
              "Year":"2019",
              "Rated":"PG-13",
              "Released":"02 Jul 2019",
              "Runtime":"129 min",
              "Genre":"Action, Adventure, Sci-Fi",
              "Director":"Jon Watts",
              "Writer":"Chris McKenna, Erik Sommers, Stan Lee",
              "Actors":"Tom Holland, Samuel L. Jackson, Jake Gyllenhaal",
              "Plot":"Following the events of Avengers: Endgame (2019), Spider-Man must step up to take on new threats in a world that has changed forever.",
              "Language":"English, Italian, Czech",
              "Country":"United States",
              "Awards":"10 wins & 26 nominations",
              "Poster":"https://m.media-amazon.com/images/M/MV5BMGZlNTY1ZWUtYTMzNC00ZjUyLWE0MjQtMTMxN2E3ODYxMWVmXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_SX300.jpg",
              "Ratings":[
                  {
                      "Source":"Internet Movie Database",
                      "Value":"7.4/10"
                  },
                  {
                      "Source":"Rotten Tomatoes",
                      "Value":"90%"
                  },
                  {
                      "Source":"Metacritic",
                      "Value":"69/100"
                  }
              ],
              "Metascore":"69",
              "imdbRating":"7.4",
              "imdbVotes":"405,102",
              "imdbID":"tt6320628",
              "Type":"movie",
              "DVD":"27 Aug 2019",
              "BoxOffice":"$390,532,085",
              "Production":"N/A",
              "Website":"N/A",
              "Response":"True"
          }

    
    
  And then assert the key values in json objects. 
    



