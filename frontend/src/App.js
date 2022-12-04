import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";

class App extends Component {
  state = {
    users: []
  };

  async componentDidMount() {
    const response = await fetch('/users');
    const body = await response.json();
    this.setState({users: body});
  }

  render() {
    const {users} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Users</h2>
              {users.map(user =>
                  <div key={user.id}>
                    {user.firstname} {user.lastname}  ({user.email})
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;


