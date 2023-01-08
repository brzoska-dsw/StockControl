import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';

const BomRows = (props) => {

  const [state, setState] = useState([]);
  const [stateUnit, setStateUnit] = useState([]);

  let bomListResult = [];
  let bomListResult1 = [];

  const matrix = (props) => {
    props.rows.map((item) => {
      return item.bom.map((item1) =>
        bomListResult.push({
          partNo: item.partNo,
          kanban: item.kanban,
          uniteNo: item1.unite.uniteNo,
          qty: item1.qty,
        })
      );
    });
  };

  const unites = (props) => {
    props.cols.map((item) => {
      return bomListResult1.push({ uniteNo: item.uniteNo });
    });
  };

  useEffect(() => {
     matrix(props);
     setState(bomListResult);
     }, [props]);

  useEffect(() => {
    unites(props);
    setStateUnit(bomListResult1);
  }, [props]);

  return (
    <Container>
      <Table striped bordered hover className="cls">
        <thead>
          <tr>
            <th>Kanban</th>
            <th>PartNo</th>
            {stateUnit.map((item) => {
              return <th key={item.uniteNo}>{item.uniteNo}</th>;
            })}
          </tr>
        </thead>

        <tbody>
          {state.map((item) => {
            return item.map((item1) => {
              return (
                <tr>
                  <td>{item1.qty}</td>
                </tr>
              );
            });
          })}
        </tbody>
      </Table>
    </Container>
  );
}
export default BomRows;
