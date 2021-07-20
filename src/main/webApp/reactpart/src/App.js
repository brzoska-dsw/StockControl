import './App.css';
import Row from './Row';
import React, { useState, useEffect } from 'react';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {

  const [state, setState] = useState([]);
  const [stateForm, setStateForm] = useState(
    {
      // id: 0,
      // partMaster: '',
      // u001: '',
      // u002: '',
      // u003: '',
      // u004: '',
      // u005: '',
      // u006: '',
      // u007: '',
      // u008: '',
    }
  );

  const getStockData = () => {
    return fetch('http://localhost:8080/api/unite')
      .then(response => response.json())
  }

  const persistStockData = (item) => {
      return fetch('http://localhost:8080/api/unite/post', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(item )
    })
      .then(data => data.json())
  }

  useEffect(() => {
    let mounted = true;
    getStockData()
      .then(data => {
        if (mounted) {
          // console.log(data);
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
    // id,
    partMaster,
    u001,
    u002,
    u003,
    u004,
    u005,
    u006,
    u007,
    u008
  } = stateForm;

  return (
    <div>

      <Container>

        <Form onSubmit={onSubmitHandler}>
          <FormControl autoComplete="off"
            type="text"
            name="partMaster"
            placeholder="partMaster"
            value={partMaster}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u001"
            placeholder="U001"
            value={u001}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u002"
            placeholder="U002"
            value={u002}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u003"
            placeholder="U003"
            value={u003}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u004"
            placeholder="U004"
            value={u004}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u005"
            placeholder="U005"
            value={u005}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u006"
            placeholder="U006"
            value={u006}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u007"
            placeholder="U007"
            value={u007}
            onChange={onChangehendler} />
          <FormControl autoComplete="off"
            type="text"
            name="u008"
            placeholder="U008"
            value={u008}
            onChange={onChangehendler} />
          <Button variant="success" type="submit" >zapisz</Button>
        </Form>
      </Container>
      <br />
      <br />
      <Row rows={state} />
    </div >
  );
}

export default App;
