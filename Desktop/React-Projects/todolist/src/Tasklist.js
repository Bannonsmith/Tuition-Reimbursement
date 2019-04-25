import React,{Component} from 'react';
import './App.css';

class Tasklist extends Component {

    handleRemoveClick = (name) => {
        this.props.removeTaskCalback(name)
    }
    let completedTasks={props.completedTasks}
    render(props) {
        let tasks = this.props.tasks

        let taskItems = this.props.tasks.map((task,index) => {
            return(
                <div className="flex">
                    <li key={index}>{task}</li>
                    <button onClick={() => this.handleRemoveClick()}className="red">Mark as Completed</button>
                </div>
            )
        })

        return (
            <div>
                <h1 className="purple">Pending Items</h1>
                <ul>{taskItems}</ul>
                
            </div>
            
        );
    }
}

export default Tasklist;