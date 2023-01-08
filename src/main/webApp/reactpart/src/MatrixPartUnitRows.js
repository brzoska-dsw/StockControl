import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';

const BomPartsRows = (props) => {

  const [state, setState] = useState([]);
  let bomListResult = [];

  const matrix = (props) => {
    props.rows.map((item) => {
      return item.bomList.map((item1) =>
        bomListResult.push({
          uniteNo: item.uniteNo,
          kanban: item1.part.kanban,
          qty: item1.qty,
          partNo: item1.part.partNo,
        })
      );
    });
  };

  useEffect(() => {
    matrix(props);
    setState(bomListResult);
  }, [props]);

  return (
    <Container>
      <Table striped bordered hover className="cls">

        <thead>
          <tr>
            <th>uniteNo</th>
            <th>partNo</th>
            <th>kanban</th>
            <th>qty</th>
          </tr>
        </thead>

        <tbody>
          {state.map(item => {
            return(
            <tr>
              <td>{item.uniteNo}</td>
              <td>{item.partNo}</td>
              <td>{item.qty}</td>
              <td>{item.qty}</td>
            </tr>
            )
          })}
        </tbody>
      </Table>
    </Container>
  );
};
export default BomPartsRows;