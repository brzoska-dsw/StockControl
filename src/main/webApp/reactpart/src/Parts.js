import "./App.css";
import React, { useState, useEffect } from "react";
import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import "bootstrap/dist/css/bootstrap.min.css";
import { Col, Row } from "react-bootstrap";
import PartRows from "./PartRows";

const Parts = () => {
  const [state, setState] = useState([]);
  const [stateForm, setStateForm] = useState({
    partNo: "",
    kanban: "",
  });

  const getStockData = () => {
    return fetch("/part").then((data) => data.json());
  };

  const persistStockData = (item) => {
    return fetch("/part/post", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    }).then((data) => data.json());
  };

  useEffect(() => {
    let mounted = true;
    getStockData().then((data) => {
      if (mounted) {
        console.log(data);
        setState(data);
      }
    });
    return () => (mounted = false);
  }, []);

  const onSubmitHandler = (e) => {
    e.preventDefault();
    persistStockData(stateForm);
    getStockData().then((e) => setState(e));
    console.log(state);
  };

  const onChangehendler = (e) => {
    e.preventDefault();
    setStateForm({ ...stateForm, [e.target.name]: e.target.value });
  };

  const { partNo, kanban } = stateForm;

  return (
    <div>
      <Container>
        <Form onSubmit={onSubmitHandler}>
          <Row>
            <Col sm={2}>
              <Form.Label>Part Number</Form.Label>
            </Col>
            <Col sm={3}>
              <FormControl
                autoComplete="off"
                type="text"
                name="partNo"
                placeholder="Part Number"
                value={partNo}
                onChange={onChangehendler}
              />
            </Col>
          </Row>
          <Row>
            <Col sm={2}>
              <Form.Label>Kanban Number</Form.Label>
            </Col>
            <Col sm={3}>
              <FormControl
                autoComplete="off"
                type="text"
                name="kanban"
                placeholder="Kanban Number"
                value={kanban}
                onChange={onChangehendler}
              />
            </Col>
          </Row>
          <Button variant="success" type="submit">
            zapisz
          </Button>
          <p>Po zapisaniu odśwież stronę, aby zobaczyć zmiany</p>
        </Form>
      </Container>
      <br />
      <br />
      <PartRows rows={state} />
    </div>
  );
};

export default Parts;
