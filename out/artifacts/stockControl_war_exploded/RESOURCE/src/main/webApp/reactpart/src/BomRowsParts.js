import React, { useEffect } from 'react';
import { useState } from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';


const BomRowsParts = props => {

  const [state, setState] = useState([]);

  const matrix = () => {

    let bomListResult = [];
console.log(props.rows);
    props.rows.map(
      item => {
        return item.bom.map
          (
            item1 => bomListResult.push
              (
                {
                  partNo: item.partNo,
                  qty: item1.qty,
                  uniteNo: item1.unite.uniteNo
                }
              )
          )
      }
    )
    console.log(bomListResult)
    setState(bomListResult)

  }

  
  useEffect(() => {
    matrix();
  }, []);

  return (
    <Container>
      <Table striped bordered hover className="cls">

        <thead>
          <tr >
            <th>Kanban</th>
            <th> PartNo </th>
            {state.map
              (
                item => { <th>{item.partNo}</th> }
              )
            }
          </tr>
        </thead>

        <tbody>
          {state.map
            (
              item => {

                (
                  <tr>
                    <td>
                      {item.qty}
                    </td>
                    <td>
                      {item.partNo}
                    </td>
                  </tr>
                )
              }
            )
          }

        </tbody>

      </Table>
    </Container>
  );
}
export default BomRowsParts;