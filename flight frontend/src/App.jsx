import './App.css'

import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'

import AddFlight from './components/add-flight'
import ListFlights from './components/list-flights'
import FindCode from './components/find-code'
import FindCarrier from './components/find-carrier'
import FindPrice from './components/find-price'
import FindRoute from './components/find-route'

export default function App() {

  return (

    <BrowserRouter>

      <div className='main-container'>

        <div className='topbar'>

          <div className='logo'>
            SkyRoute ✈
          </div>

          <div className='nav-links'>

            <Link to='/' className='nav-btn'>
              Flights
            </Link>

            <Link to='/add' className='nav-btn'>
              Add Flight
            </Link>

            <Link to='/code' className='nav-btn'>
              Search Code
            </Link>

            <Link to='/carrier' className='nav-btn'>
              Carrier
            </Link>

            <Link to='/price' className='nav-btn'>
              Price
            </Link>

            <Link to='/route' className='nav-btn'>
              Route
            </Link>

          </div>

        </div>

        <div className='page'>

          <Routes>

            <Route path='/' element={<ListFlights />} />

            <Route path='/add' element={<AddFlight />} />

            <Route path='/code' element={<FindCode />} />

            <Route path='/carrier' element={<FindCarrier />} />

            <Route path='/price' element={<FindPrice />} />

            <Route path='/route' element={<FindRoute />} />

          </Routes>

        </div>

      </div>

    </BrowserRouter>

  )
}