import logo from './logo.svg';
import './App.css';
import Todolist from './component/Todolist';
import { useEffect, useState } from 'react';
import axios from "axios";
function App() {
  const [todoData, setTododata] = useState([]);

  useEffect(()=>{
    axios.get("http://localhost:8080/todo/getAllList").then((response)=>{
        console.log("response ", response.data);
        setTododata(response.data)
    })
    .catch((reject)=>{
        console.log("Reject ", reject)
    })
},[])
  return (
    <div className="app-container">
      <Todolist todoData={todoData}/>
    </div>
  );
}

export default App;
