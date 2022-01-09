import './App.css';
import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import BomRowsParts from './BomRowsParts';

const BomPart = () => {

  const [state, setState] = useState([]);

  const getStockData = () => {
    return fetch('/part')
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

  return (
    <div>
      <BomRowsParts rows={state} />
    </div >
  );
}

export default BomPart;
