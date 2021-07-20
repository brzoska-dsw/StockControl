import React from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './Row.css';


const Row = props => {

  return (
    <Container>
      <Table striped bordered hover className="cls">
        <thead>
          <tr >
            <th>#</th>
            <th>Kanban</th>
            <th>U001</th>
            <th>U002</th>
            <th>U003</th>
            <th>U004</th>
            <th>U005</th>
            <th>U006</th>
            <th>U007</th>
            <th>U008</th>
          </tr>
        </thead>
        <tbody>
          {props.rows.map
            (item => {
              return (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.partMaster}</td>
                  <td>{item.u001}</td>
                  <td>{item.u002}</td>
                  <td>{item.u003}</td>
                  <td>{item.u004}</td>
                  <td>{item.u005}</td>
                  <td>{item.u006}</td>
                  <td>{item.u007}</td>
                  <td>{item.u008}</td>
                </tr>
              )
            })
          }
        </tbody>
      </Table>
    </Container>
  );
}
export default Row;



/* <Navbar bg="dark" expand="lg" variant="dark">

        <Navbar.Brand href="#home">
          <img
            src="dental.png"
            width="30"
            height="30"
            className="d-inline-block align-top"
            alt=""
          /> {' '}
          HOME
        </Navbar.Brand>

        <Nav>
          <Nav.Link href="#link2">Artykuły</Nav.Link>
          <Nav.Link href="#link2">Link</Nav.Link>
          <NavDropdown title="Dropdown" id="basic-nav-dropdown">
            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
          </NavDropdown>
        </Nav>

        <Navbar.Toggle aria-controls="basic-navbar-nav" />
      </Navbar> */