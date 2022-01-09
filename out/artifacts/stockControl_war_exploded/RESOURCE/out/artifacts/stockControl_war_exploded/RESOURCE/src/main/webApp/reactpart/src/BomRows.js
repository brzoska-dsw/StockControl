import React, { useEffect } from 'react';
// import { useState } from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import './UnitRows.css';


const BomRows = props => {

  // const [list, setList] = useState([]);

  let bomListResult = [];

  let matrix = () => {
    props.rows.map(
      item => 
      {
        return item.bomList.map
        (item1 => bomListResult.push
          (
            {
              uniteNo: item.uniteNo,
              partNo: item1.part.partNo,
              qty: item1.qty
            }
          )
        )
      }
    )
    return bomListResult
  }

  useEffect(() => {
    console.log(matrix());
  });

  return (
    <Container>
      <Table striped bordered hover className="cls">

        <thead>
          <tr >
            <th>Kanban</th>
            <th> PartNo </th>
            {props.rows.map(item => {
              return (
                <th key={item.uniteNo} >{item.uniteNo}</th>
              )
            })}
          </tr>
        </thead>

        <tbody>

          {props.rows.map
            (item => {
              return
              (
                item.bomList.map
                  ((item1) => {
                    return
                    (
                      <tr>
                        <td>
                          {item1.qty}
                        </td>
                        <td>
                          {item1.part.partNo}
                        </td>
                      </tr>
                    )
                  }
                  )
              )
            }
            )
          }

        </tbody>

      </Table>
    </Container>
  );
}
export default BomRows;

{/* <thead>
<tr >
  <th>Unite No</th>
  <th>Short No</th>
  <th>Bom</th>
</tr>
</thead>
<tbody>
{props.rows.map
  (item => {
    return (

      item.bomList.map((item1) => {
        return (
          <tr>
            <td>
            {item.uniteNo}
            </td>
            <td>
            {item1.part.partNo}
            </td>
          </tr>
        )
      })

      // przenieść za </body
    )
  })
}
</tbody> */}