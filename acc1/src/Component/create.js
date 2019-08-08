import React, { Component } from 'react';
import { Input, Label} from 'reactstrap';

import Axios from 'axios';

class Create extends Component {

    constructor() {
        super();
        this.state = {
            prize: "",
            accountNum: ""
        }
    }

    handleSubmit = event => {
        event.preventDefault();
        const newItem = {
            firstName: event.target[0].value,
            lastName: event.target[1].value
           
        }
        Axios.post("http://localhost:8080/createAccount", newItem)
            .then(response => {
               this.setState({
                   prize: response.data.prize,
                   accountNum: "Your account number is:",
                   response:  response.data.accountNumber
               })

            });



    }


render(){

    return (
        <div className="container">
            <br></br>
            <br></br>
            <br></br>
            <h1> Create Account </h1>
            <br></br>
            <br></br>

            <form onSubmit={this.handleSubmit}>
                <Label>
                    First Name
                        </Label>
                        <Input type="text"></Input>
                <Label>
                    Last Name
    </Label>
    <Input type="text"></Input>

     <input type="submit" value="Submit" />
     <p style={{ color: 'blue' }}> {this.state.accountNum} {this.state.response}</p>
     <p style={{ color: 'blue' }}>{this.state.prize}</p>
            </form>
        </div>


    )
}
}

export default Create;
