const express = require('express')
const app = express()
const cors = require('cors')
const bodyParser = require('body-parser')

app.use(cors())
app.use(bodyParser.json())

let books = [
    {title: "The Vampire Chronicles",
     genre: "fiction",
     publisher: "Knopf",
     year: 2019,
     imageURL: "https://upload.wikimedia.org/wikipedia/en/thumb/9/99/The_Complete_Vampire_Chronicles_cover.jpg/220px-The_Complete_Vampire_Chronicles_cover.jpg",
     id: 1
}      


]

app.post("/api/books", (req,res) => {

    let title = req.body.title
    let genre = req.body.genre
    let publisher = req.body.publisher
    let year = req.body.year
    let imageURL = req.body.imageURL

    console.log("IT worked")
    console.log(title)
    console.log(year)

    books.push({title: title, genre: genre, publisher: publisher, year: year, imageURL: imageURL})
    res.json({success: true, message: "Sucessfully added a book!"})
})
app.get('/api/books',(req,res) => {
    res.json(books)
})



app.listen(5000,() => {
    console.log("Server is running")
})