import React,{Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Tasklist from './Tasklist';

class App extends Component {

  constructor() {
    super()

    this.state = {
      task: '',
      tasks: [],
      completedTasks: []
    }
  }
  enterText = (e) => {
    this.setState({
      task: e.target.value
    })
  }

  saveTask = () => {
    this.setState({
      tasks: this.state.tasks.concat(this.state.task)
    })
  }

  removeTask =  (name) => {
    console.log("handleRemoveClick in App.js")
    console.log(name)
    this.setState({
      pendingItems: this.state.pendingItems.filter((item) => item != name)
    })
  }

  render() {
    return (
      <div className="main">
        <input onChange={this.enterText} type="text" placeholder="Add Task"/>
        <button onClick={this.saveTask} className="green">Add</button>
        <br></br>

        <Tasklist tasks={this.state.tasks} removeTaskCalback={this.removeTask}/>
        <hr></hr>
        {/* <Completedlist completedTasks={this.state.completedTasks}/> */}
      </div>
  
    );
  }

 
}

export default App;
