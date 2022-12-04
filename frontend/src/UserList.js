import React, { Component } from 'react';
//import { Button, ButtonGroup, Container, Table } from 'reactstrap';
//import AppNavbar from './AppNavbar';
//import { Link } from 'react-router-dom';

class UserList extends Component {

    constructor(props) {
        super(props);
        this.state = {users: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/users')
            .then(response => response.json())
            .then(data => this.setState({users: data}));
    }
}
export default UserList;