import React from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';


const PartRows = props => {

  return (
    <Container>
      <Table striped bordered hover className="cls">
        <thead>
          <tr >
            <th>Part No</th>
            <th>Kanban No</th>
          </tr>
        </thead>
        <tbody>
          {props.rows.map
            (item => {
              return (
                <tr key={item.partNo}>
                  <td>{item.partNo}</td>
                  <td>{item.kanban}</td>
                </tr>
              );
            })
          }
        </tbody>
      </Table>
    </Container>
  );
}
export default PartRows;