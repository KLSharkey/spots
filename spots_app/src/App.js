import React, { Component } from 'react';
import spotsLogo from './assets/images/spotsLogo.jpg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
        <h1 className="App-title">Welcome to Spots</h1>
          <img src={spotsLogo} className="App-logo" alt="logo" />
          
        </header>
        <p className="App-intro">
          Start Living. Drop Spots.
        </p>
      </div>
    );
  }
}

export default App;
