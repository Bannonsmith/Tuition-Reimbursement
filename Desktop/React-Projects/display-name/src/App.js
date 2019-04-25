import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import InputName from "./InputName";
// import DisplayName from "./DisplayName";


class App extends Component {
  render() {
    return (
      <div>
        <InputName />
        {/* <DisplayName /> */}
      </div>
      );
  }

}

export default App;
