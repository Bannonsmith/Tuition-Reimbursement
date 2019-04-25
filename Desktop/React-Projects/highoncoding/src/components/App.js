import React, { Component } from 'react';
import Header from './Header';
import Review from "./Review";
import Body from "./Body";
import "../style/body.css";


class App extends Component {
  render() {
    return (
      <div className="app">
        <Header />
        <Review />
        <Body />
      </div>
    );
  }
}

export default App;
