import './App.css';
import React from 'react';
import Units from './Units';
import MatrixPartUnit from "./MatrixPartUnit";
import Bom from './Bom';
import Parts from './Parts';
import NotFound from './NotFound';
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Container from 'react-bootstrap/Container'

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

const App = () => {

  return (
    <div>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#Home">
            <img
              alt=""
              src="/iconfinder_GEAR.png"
              width="30"
              height="30"
              className="d-inline-block align-top"
            />
            {"   "}
            HOME
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/units">Units</Nav.Link>
            <Nav.Link href="/parts">Parts</Nav.Link>
            <Nav.Link href="/unit">UnitParts</Nav.Link>
            <Nav.Link href="/bom">Bom</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Router>
        <Switch>
          <Route path="/units" component={Units} />
          <Route path="/parts" component={Parts} />
          <Route path="/unit" component={MatrixPartUnit} />
          <Route path="/bom" component={Bom} />
          <Route component={NotFound} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
