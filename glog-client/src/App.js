import React from 'react';
import { Switch, Route} from 'react-router-dom';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import Mypage from './pages/MyPage';
import Main from './pages/Main';
import './App.css'


function App() {
  return (
    <div className="appContainer">
      <Switch>
        <Route exact path='/'>
          <Main/>
        </Route>
        <Route path='/signin'>
          <SignIn/>
        </Route>
        <Route path='/signup'>
          <SignUp/>
        </Route>
        <Route path="/mypage">
          <Mypage/>
        </Route>
      </Switch>
    </div>
  );
}

export default App;
