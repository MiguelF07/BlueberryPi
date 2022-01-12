import React from "react";
import Accordion from 'react-bootstrap/Accordion';
import LocationInfo from "./LocationInfo";
import DailyInfo from "./DailyInfo";

const MyAccordion = () => {

    let arr = [1,2,3]
    let imgs = [
        "https://www.tecnologiahorticola.com/wp-content/uploads/2019/03/New_Plantation_Croatia-2.jpg",
        "https://projarinternational.com/wp-content/uploads/2020/06/vivero_arandano-scaled.jpg",
        "https://s3.envato.com/files/e641f05c-c3ce-4f19-8eb6-12bdb53ea528/inline_image_preview.jpg"
    ]

    // TODO: fill out the units of each thing here
    let pt = "plantation_temperature";
    let pt_u = "ºC";
    let nh = "net_harvest";
    let nh_u = "";
    let sp = "soil_ph";
    let sp_u = "";
    let swt = "soil_water_tension";
    let swt_u = "";
    let ul = "unit_loss";
    let ul_u = "";
    let st = "storage_temperature";
    let st_u = "";
    let sh = "storage_humidity";
    let sh_u = "";

    return(

        <div>
            <div style={{margin: '3%' }}>
                <LocationInfo />
            </div>
            <div style={{ width: '50%', margin: 'auto', marginTop: '1%' }}>
                <Accordion defaultActiveKey="0" flush>
                    
                    {
                        arr.map(
                        (elem) => { return (

                            <Accordion.Item eventKey={(elem - 1).toString()}>
                                
                                <Accordion.Header>{"Location " + elem}</Accordion.Header>

                                <Accordion.Body style={{ backgroundImage: 'url(' + imgs[elem-1] + ')' }}>
                                <div style={{ position: 'relative' }}>
                                    {/* style={{ margin: '0 auto', backgroundImage: '@Url.Content(imgs[{elem-1}])' }} */}
                                    <table style={{ margin: '0 auto' }}>
                                        <tbody>
                                            <tr>
                                                <td> <DailyInfo dataType={pt} units={pt_u} location={elem} /> </td>
                                                <td> <DailyInfo dataType={nh} units={nh_u} location={elem} /> </td>
                                                <td> <DailyInfo dataType={sp} units={sp_u} location={elem} /> </td>
                                            </tr>
                                            <tr>
                                                <td> <DailyInfo dataType={swt} units={swt_u} location={elem} /> </td>
                                                <td> <DailyInfo dataType={ul} units={ul_u} location={elem} /> </td>
                                                <td> <DailyInfo dataType={st} units={st_u} location={elem} /> </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td> <DailyInfo dataType={sh} units={sh_u} location={elem} /> </td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                </div>
                                </Accordion.Body>

                            </Accordion.Item>
                        
                        ) }
                        )
                    }

                </Accordion>
            </div>
        </div>

    )

}

export default MyAccordion;