import './App.css';
import React, { useState, useEffect } from 'react';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Col, Row } from 'react-bootstrap';
import UnitRows from './UnitRows';

const Units = () => {

  const [state, setState] = useState([]);
  const [stateForm, setStateForm] = useState(
    {
      uniteNo: '',
      shortNo: '',
    }
  );

  const getStockData = () => {
    return fetch('/unite')
      .then(data => data.json())  
  }

  const persistStockData = (item) => {
    return fetch('/unite/post', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(item)
    })
      .then(data => data.json())
  }

  useEffect(() => {
    let mounted = true;
    getStockData()
      .then(data => {
        if (mounted) {
          console.log(data);
          setState(data);
        }
      })
    return () => mounted = false;
  }, []);

  const onSubmitHandler = e => {
    e.preventDefault();
    persistStockData(stateForm);
    getStockData().then(e => setState(e));
    console.log(state)
  };

  const onChangehendler = e => {
    e.preventDefault();
    setStateForm({ ...stateForm, [e.target.name]: e.target.value });
  };

  const {
    uniteNo,
    shortNo
  } = stateForm;

  return (
    <div>
      <Container>
        <Form onSubmit={onSubmitHandler}>
          <Row>
            <Col sm={2}>
              <Form.Label >
                Unit Number
              </Form.Label>
            </Col>
            <Col sm={3}>
              <FormControl autoComplete="off"
                type="text"
                name="uniteNo"
                placeholder="Unit Number"
                value={uniteNo}
                onChange={onChangehendler} />
            </Col>
          </Row>
          <Row>
            <Col sm={2}>
              <Form.Label >
                Short Number
              </Form.Label>
            </Col>
            <Col sm={3}>
              <FormControl autoComplete="off"
                type="text"
                name="shortNo"
                placeholder="Short Number"
                value={shortNo}
                onChange={onChangehendler} />
            </Col>
          </Row>
          <Button variant="success" type="submit" >zapisz</Button>
        </Form>
      </Container>
      <br />
      <br />
      <UnitRows rows={state} />
    </div >
  );
}

export default Units;
