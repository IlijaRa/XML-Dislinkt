import React from 'react'

export default function Login() {
  return (
    <div><div className="login-wrap">
    <div className="login-html">
    
     
      <div className="login-form">
        <div className="sign-in-htm">
          <div className="group">
            <label htmlFor="user" className="label">
              Username
            </label>
            <input id="user" type="text" className="input" />
          </div>
          <div className="group">
            <label htmlFor="pass" className="label">
              Password
            </label>
            <input
              id="pass"
              type="password"
              className="input"
              data-type="password"
            />
          </div>
          <div className="group">
            <input
              id="check"
              type="checkbox"
              className="check"
              defaultChecked=""
            />
            <label htmlFor="check">
            <label htmlFor="user" className="label">
             Keep me singed in
            </label>
            </label>
          </div>
          <div className="group">
            <input type="submit" className="button" defaultValue="Sign In" />
          </div>
          <div className="hr" />
          <div className="foot-lnk">
            <a href="#forgot">Forgot Password?</a>
          </div>
        </div>
        
      </div>
    </div>
  </div>
  </div>
  )
}
