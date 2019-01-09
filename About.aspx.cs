using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace LINQDemo
{
    public partial class About : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                D13DataContext db = new D13DataContext();
                var query = from kh in db.KHACHHANGs select new {
                                                MaKH = kh.MAKH,
                                                TenKH=kh.TENKH,
                                                DiaChi=kh.DIACHI,
                                                ThanhPho = kh.THANHPHO,
                                                DienThoai=kh.DIENTHOAI
                                                };
                lvKhachHang.DataSource = query;
                lvKhachHang.DataBind();
            }
            catch(Exception ex)
            {
                Console.WriteLine("loi " + ex.Message);
            }
        }
    }
}