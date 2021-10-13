import React from 'react';
import { Switch, Route} from 'react-router-dom';
import Header from './pages/Header';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import Mypage from './pages/MyPage';


function App() {
  return (
    <div>
      <Header/>
      <Switch>
        <Route exact path='/signin'>
          <SignIn/>
        </Route>
        <Route exact path='/signup'>
          <SignUp/>
        </Route>
        <Route exact path="/mypage">
          <Mypage/>
        </Route>
      </Switch>
    </div>
  );
}

export default App;
