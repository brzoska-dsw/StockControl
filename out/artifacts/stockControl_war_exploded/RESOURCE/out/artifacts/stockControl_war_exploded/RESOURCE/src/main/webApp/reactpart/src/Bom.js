import './App.css';
import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import BomRows from './BomRows';

const Bom = () => {

  const [state, setState] = useState([]);
  const [stateForm, setStateForm] = useState(
    {
      uniteNo: '',
      shortNo: '',
      bomList: {
        part: {
          partNo: '',
          kanban: ''
        },
        qty: '',
      },
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

  const {
      uniteNo,
      shortNo,
      bomList: {
        part: {
          partNo,
          kanban
        },
        qty
      },
  } = stateForm;

  return (
    <div>
      <BomRows rows={state} />
    </div >
  );
}

export default Bom;
