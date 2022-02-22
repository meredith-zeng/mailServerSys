import React from "react";

import { userInfo } from './data/api';

interface UserContextType {
  user: any;
  getUserInfo: (onSuccess: any, onError: any) => void;
}

const UserContext = React.createContext<UserContextType>(null!);

export function useUser() {
  return React.useContext(UserContext);
}

export default function UserProvider({ children }: { children: React.ReactNode }) {
  let [user, setUser] = React.useState({});

  const getUserInfo = (onSuccess: any, onError: any) => {
    userInfo().then(({data, error}) => {
      if(!error) {
        setUser(data);
        onSuccess();
      } else {
        onError();
      }
    });
  };

  return <UserContext.Provider value={{user, getUserInfo}}>{children}</UserContext.Provider>;
}
