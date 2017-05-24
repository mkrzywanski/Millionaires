
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Play with Scala.js")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
"""),format.raw/*4.1*/("""<h2>Play and Scala.js share a same message</h2>
<ul>
  <li>Play shouts out: <em>"""),_display_(/*6.29*/message),format.raw/*6.36*/("""</em></li>
  <li>Scala.js shouts out: <em id="scalajsShoutOut"></em></li>
  <button id="Next">Click</button>
</ul>
""")))}),format.raw/*10.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Tue May 23 11:01:01 CEST 2017
                  SOURCE: /home/michal/Pulpit/play-with-scalajs-example-master/server/app/views/index.scala.html
                  HASH: ae6a61bec35b27d7e5f4e1d3da15ba06537391fc
                  MATRIX: 527->1|639->18|667->21|701->47|740->49|767->50|874->131|901->138|1047->254
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|30->6|30->6|34->10
                  -- GENERATED --
              */
          