import React from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';


const UnitRows = props => {

  return (
    <Container>
      <Table striped bordered hover className="cls">
        <thead>
          <tr >
            <th>Unite No</th>
            <th>Short No</th>
          </tr>
        </thead>
        <tbody>
          {props.rows.map
            (item => {
              return (
                <tr key={item.uniteNo}>
                  <td>{item.uniteNo}</td>
                  <td>{item.shortNo}</td>

                </tr>
              )
            })
          }
        </tbody>
      </Table>
    </Container>
  );
}
export default UnitRows;