import "./App.css";
import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import MatrixPartUnitRows from "./MatrixPartUnitRows";

const MatrixPartUnit = () => {
  const [state, setState] = useState([]);

  const getStockData = () => {
    return fetch("/unit").then((data) => data.json());
  };

  useEffect(() => {
    let mounted = true;
    getStockData().then((data) => {
      if (mounted) {
        setState(data);
      }
    });
    return () => (mounted = false);
  }, []);

  return (
    <div>
      <MatrixPartUnitRows rows={state} />
    </div>
  );
};

export default MatrixPartUnit;
