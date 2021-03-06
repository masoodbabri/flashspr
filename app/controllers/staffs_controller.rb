class StaffsController < ApplicationController
  require 'rest-client'
  after_action :verify_authorized, except: [:index, :show, :sndkudo]

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

    $curUserStaff = Staff.find_by_email(current_user.email)
    @curUser = current_user.email
    @staff = Staff.find_by_email(@curUser)
    @last10Kudos = Kudo.last(5).reverse;
    @sentKudos = Kudo.where(:sender => @curUser)
    authorize :staff, :login_process?

  end

  def show
    @staff = Staff.find(params[:id])
  end

  # FIXME: this method should be using show
  def sndkudo
    @staff = Staff.find(params[:id])
    @category = Category.all
  end

  # FIXME: this method should be using show
  def erstaff
    @staff = Staff.find(params[:id])
    authorize @staff
  end

  def new
    @staff = Staff.new
    authorize @staff
  end

  def create
    @staff = Staff.new(staff_params)
    authorize @staff

    if @staff.save
      redirect_to @staff
    else
      render 'new'
    end
  end

  def edit
    @staff = Staff.find(params[:id])
    authorize @staff
  end

  def update
    @staff = Staff.find(params[:id])
    authorize @staff
    if @staff.update(staff_params)
      redirect_to @staff
    else
      render 'edit'
    end
  end

  def destroy
    staff = Staff.find(params[:id])
    authorize staff
    staff.destroy
    redirect_to staffs_path
  end

  private
  def staff_params
    params.require(:staff).permit(:first_name, :last_name, :title, :email)
  end
  
end
