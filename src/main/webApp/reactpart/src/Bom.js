import './App.css';
import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import BomRows from './BomRows';

const Bom = () => {

  const [stateParts, setStateParts] = useState([]);
  const [stateUnits, setStateUnites] = useState([]);

  const getStockData = () => {
    return fetch('/part')
      .then(data => data.json())
  }

  const getStockCols = () => {
    return fetch("/unit")
    .then((data) => data.json());
  };

  // const persistStockData = (item) => {
  //   return fetch('/unite/post', {
  //     method: 'POST',
  //     headers: {
  //       'Content-Type': 'application/json',
  //     },
  //     body: JSON.stringify(item)
  //   })
  //     .then(data => data.json())
  // }

  useEffect(() => {
    let mounted = true;
    getStockData()
      .then(data => {
        if (mounted) {
          setStateParts(data)
        }
      });

    getStockCols()
      .then((data1) => {
        if (mounted) {
          setStateUnites(data1)
        }
      });  

    return () => mounted = false;

  }, []);

  return (
    <div>
      <BomRows rows={stateParts} cols={stateUnits} />
    </div>
  );
}

export default Bom;
