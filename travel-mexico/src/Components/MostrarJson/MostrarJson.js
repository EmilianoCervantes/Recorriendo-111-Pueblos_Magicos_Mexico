/**
 * 
 */
import React, {Component} from 'react';
import './MostrarJson.css';

import Json from '../Json/Json';

const puebloInicial = '';
const puebloFinal = '';
class MostrarJson extends Component {
    constructor(props){
        super(props);
        this.state = {puebloInicial, puebloFinal};
    }
    render () {
        return (
            <div className="App">
                <form>
                    <input className="puebloInicial"/>
                    <input className="puebloFinal" />
                </form>
                <Json puebloInicial={puebloInicial} puebloFinal={puebloFinal} />
            </div>
        );
    }
}

export default MostrarJson;