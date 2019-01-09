<%@ Page Title="About" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.cs" Inherits="LINQDemo.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    
    <asp:ListView ID="lvKhachHang" runat="server">
        <LayoutTemplate>
                <table id="Table1" runat="server">
                    <tr id="Tr1" runat="server">
                        <td id="Td1" runat="server">
                            <table ID="itemPlaceholderContainer" runat="server" border="0" style="">
                                <tr id="Tr2" runat="server" style="">
                                    <th id="Th1" runat="server">
                                    </th>

                                    <th id="Th2" runat="server">
                                        Ma KH</th>

                                    <th id="Th3" runat="server">

                                        Ten KH</th>

                                    <th id="Th4" runat="server">
                                        Dia Chi </th>

                                    <th id="Th5" runat="server">
                                        Thanh pho</th>    
                                     <th id="Th6" runat="server">
                                        Dien Thoai</th>  

                                </tr>
                                <tr ID="itemPlaceholder" runat="server">
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr id="Tr3" runat="server">
                        <td id="Td2" runat="server" style="">
                        </td>
                    </tr>
                </table>
        </LayoutTemplate>
        <ItemTemplate>
            <tr style="">
                    <td>
                        <asp:Button ID="DeleteButton" runat="server" CommandName="Delete"  Text="Delete" />
                        <asp:Button ID="EditButton" runat="server" CommandName="Edit" Text="Edit" />
                    </td>
                    <td>
                        <asp:Label ID="EmpIDLabel" runat="server" Text='<%# Eval("MaKH") %>' />
                    </td>
                    <td>
                        <asp:Label ID="EmpNameLabel" runat="server" Text='<%# Eval("TenKH") %>' />
                    </td>
                    <td>
                        <asp:Label ID="DepartmentLabel" runat="server" Text='<%# Eval("DiaChi") %>' />
                    </td>
                    <td>
                        <asp:Label ID="AgeLabel" runat="server" Text='<%# Eval("ThanhPho") %>' />
                    </td>
                    <td>
                        <asp:Label ID="AddressLabel" runat="server" Text='<%# Eval("DienThoai") %>' />
                    </td>
                </tr>
            </ItemTemplate>
    </asp:ListView>    
</asp:Content>

