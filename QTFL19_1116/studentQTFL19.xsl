<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://www.foo.org/" xmlns:bar="http://www.bar.org">

<xsl:template match="/">

  <html>
    <body>
      <h2>Hallgatok adatai- for-each, value-of</h2>

      <table border="4">
        <tr bgcolor="black">
          <th>ID</th>
          <th>Vnev</th>
          <th>Knev</th>
          <th>Becenev</th>
          <th>Kor</th>
          <th>Ösztöndíj</th>
        </tr>

        <xml:for-each select="class/student">
          <tr>
            <td>
              <xsl:value-of select ="@id"/>
            </td>

            <td>
              <xsl:value-of select ="@vnev"/>
            </td>

            <td>
              <xsl:value-of select ="@knev"/>
            </td>

            <td>
              <xsl:value-of select ="@becenev"/>
            </td>

            <td>
              <xsl:value-of select ="@kor"/>
            </td>

            <td>
              <xsl:value-of select ="@osztondij"/>
            </td>  
          </tr>
        </xml:for-each>
        
      </table>
    </body>
  </html>
  
</xsl:template>
</xsl:stylesheet>