
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
"""),format.raw/*4.1*/("""<h2 class="text-center">Milionerzy</h2>
    <div id="pageContent"></div>
""")))}),format.raw/*6.2*/("""
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
                  DATE: Sat Jun 10 23:47:33 CEST 2017
                  SOURCE: D:/scalaproj/scala2017_02/server/app/views/index.scala.html
                  HASH: 4084cde079fc4db1e717de60f1037e08bbdb7309
                  MATRIX: 527->1|639->18|669->23|703->49|742->51|770->53|875->129
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|30->6
                  -- GENERATED --
              */
          