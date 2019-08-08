import React, { Component } from 'react';
import { Table } from 'reactstrap';

import { Item } from './Item/item.js';

export function ItemTable(props) {
    return (
        <div>
            <Table>
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th> Account Number </th>
                        <th> Prize </th>
                    </tr>
                </thead>
                <Item data={props.data}/>
            </Table>
        </div>

    )
}