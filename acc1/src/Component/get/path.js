import React, { Component } from 'react';
import Axios from 'axios';

import { ItemTable } from './Table/Table.js';

export default class ItemPage extends Component {
    constructor() {
        super();
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        this.getAllItems();
    }

    getAllItems = () => {
        Axios.get("http://localhost:8080/getAllAccounts")
            .then(response => {
                this.setState({
                    data: response.data
                });
            }).catch(err => { console.log(err.message) });
    }


    render() {
        return (
            <div>
                <ItemTable data={this.state.data}/>
            </div>
        );
    }
}