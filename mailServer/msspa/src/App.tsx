import React, { FC, useEffect } from 'react';
import { useNavigate, Outlet } from "react-router-dom";

import { useUser } from './UserProvider';

const App: FC = () => {
  const navigate = useNavigate();
  const { getUserInfo } = useUser();

  useEffect(() => {
    getUserInfo(() => {
      navigate('/mail');
    }, () => {
      navigate('/account')
    })
  }, []);

  return <Outlet />;
};

export default App;