import React, {Component} from 'react';

class InputName extends Component {
    constructor() {
        super()
    }
    render(){
        return(
            <div>
                <h2>Submit your name</h2>
                <input type="text" placeholder="Enter your name"/>
                <button>Submit</button>
            </div>
        )
    }
}
export default InputName;