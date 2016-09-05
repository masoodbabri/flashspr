class StaffsController < ApplicationController
  require 'rest-client'

  PAGE_SIZE = 10

  def index
    @page = (params[:page] || 0).to_i
    if params[:keywords].present?
      @keywords = params[:keywords]
      staff_search_term = StaffSearchTerm.new(@keywords)
      @staffs = Staff.where(
          staff_search_term.where_clause,
          staff_search_term.where_args).
          order(staff_search_term.order).
          offset(PAGE_SIZE * @page).limit(PAGE_SIZE)
    else
      @staffs = []
    end
    respond_to do |format|
      format.html {}
      format.json { render json: @staffs }
    end
  end

  def show
    @staff = Staff.find(params[:id])
  end

  def sndkudo
    @staff = Staff.find(params[:id])
  end

  def new
    @staff = Staff.new
  end

  def create
    @staff = Staff.new(staff_params)

    if @staff.save
      redirect_to @staff
    else
      render 'new'
    end
  end

  def erstaff
    @staff = Staff.find(params[:id])
  end

  def edit
    @staff = Staff.find(params[:id])
  end

  def update
    @staff = Staff.find(params[:id])

    if @staff.update(staff_params)
      redirect_to @staff
    else
      render 'edit'
    end
  end

  def destroy
    @staff = Staff.find(params[:id])
    @staff.destroy

    redirect_to staffs_path
  end

  private
  def staff_params
    params.require(:staff).permit(:first_name, :last_name, :title, :email)
  end
  
end
