import React, { Component } from 'react';

export class Item extends Component {
    renderItem = element => {
        return (
            <tr key={element.firstName}>
                <td>{element.firstName}</td>
                <td>{element.lastName}</td>
                <td>{element.accountNumber}</td>
                <td>{element.prize}</td>
            </tr>)

    }

    render() {
        const arr = this.props.data;
        return (
            <tbody>
                {arr.map(this.renderItem)}
            </tbody >
        )
    }

}