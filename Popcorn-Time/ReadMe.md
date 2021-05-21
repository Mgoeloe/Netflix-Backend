# Movie-Service (by Popcorn Time-Team)
A Netflix clone project made by the Popcorn Time Team!
------------------------------------------------------


##Content-Type
All resources are represented in JSON

---------------------------------------------------

#Discover page Zoeken op acteur/actrice
##api/movies/search/{actor}

### Bij {actor} type je acteur of actrice naam in.
####Let op! Pas een String method toe waarbij de spatie vervangen wordt door een + dus will smith moet worden will+smith

#Discover page 80's/90's/00's movies
##api/movies/discover/{era}

####Let op! {era} is het jaartal (dus 80 of 90)

---------------------------------------------------
## Discover page - all genres
List of all genres
##api/movies/genre


---------------------------------------------------

## One Genre per ID
## api/movies/genre/{idg}

####Let op! {idg} is het genre id, zie lijst hieronder voor welke id bij welke genre hoort
###Genre id's zijn:
"id": 28,
"Action"

"id": 12,
"Adventure"

"id": 16,
"Animation"

"id": 35,
"Comedy"

"id": 80,
"Crime"

"id": 99,
"Documentary"

"id": 18,
"Drama"

"id": 10751,
"Family"

"id": 14,
"Fantasy"

"id": 36,
"History"

"id": 27,
"Horror"

"id": 10402,
"Music"

"id": 9648,
"Mystery"

"id": 10749,
"Romance"

"id": 878,
"Science Fiction"

"id": 10770,
"TV Movie"

"id": 53,
"Thriller"

"id": 10752,
"War"

"id": 37,
"Western"

---------------------------------------------------

#Discover page: Disney movies
##api/movies/disney

---------------------------------------------------

#Discover page: Tom Cruise Actor
##api/movies/tom-cruise

---------------------------------------------------

#Discover page - one movie
##api/movies/{id}

---------------------------------------------------
#Movie page - list of all movies
##api/movies/discover 

---------------------------------------------------
#Links trailer - List of trailer-links
##api/movies/{id}/video 

--------------------------------------------------------



