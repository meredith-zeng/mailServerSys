import React, { FC, useEffect, useState } from 'react';
import { useNavigate, Outlet } from "react-router-dom";

import { useUser } from './UserProvider';

const App: FC = () => {
  const navigate = useNavigate();
  const { getUserInfo } = useUser();
  let [loading, setLoading] = useState(true);

  useEffect(() => {
    getUserInfo(() => {
      navigate('/mail');
      setLoading(false);
    }, () => {
      navigate('/account');
      setLoading(false);
    })
  }, []);

  return !loading ? <Outlet /> : null;
};

export default App;