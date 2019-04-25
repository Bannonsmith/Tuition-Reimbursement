import React, {Component} from 'react';
import './App.css';

class App extends Component {

  constructor() {
    super()


    this.state = {
      books: [],
      title: "",
      genre: "",
      publisher: "",
      year: "",
      imageURL: '',
      id: ""


    }
  }
  
  componentDidMount() {
    this.populateBooks()
    
  }

    populateBooks() {
      let url = "http://localhost:5000/api/books"

    fetch(url)
    .then(response => response.json())
    .then(json => {
      this.setState({
        books: json
      })
    })
    }

    handleTextBoxChange = (e) => {
      console.log(e.target.title)

      this.setState({
        [e.target.name]:  e.target.value,
       


      })
    }

    handleSaveBook = () => {

      let book = {title: this.state.title, genre: this.state.genre, publisher: this.state.publisher, year: this.state.year, imageURL: this.state.imageURL }
      
      fetch("http://localhost:5000/api/books", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    }, body: JSON.stringify(book)


      }).then(() => {
        this.populateBooks()
      })

    }



  render() {

    let books = this.state.books
    let bookItems = books.map((book) => {
      return (
        <div>
          <ul key={book.id}>
          <li>{book.title}</li>
          <li>{book.genre}</li>
          <li>{book.publisher}</li>
          <li>{book.year}</li>
          <li><img src={book.imageURL} alt=""></img></li>
          <button>Delete</button>
          </ul>
        </div>


      )
    })
    return (
      <div>
        <h2>BookList</h2>
        <input type="text" onChange={this.handleTextBoxChange} placeholder="Title" name="title" />
        <input type="text" onChange={this.handleTextBoxChange} placeholder="Genre" name="genre" />
        <input type="text" onChange={this.handleTextBoxChange} placeholder="Publisher" name="publisher" />
        <input type="text" onChange={this.handleTextBoxChange} placeholder="Year"  name="year"/>
        <input type="text" onChange={this.handleTextBoxChange} placeholder="Image Url" name="imageURL" />
        <button onClick={this.handleSaveBook}>Save</button>
        <ul>{bookItems}</ul>
      </div>
      );
  }

}

export default App;
